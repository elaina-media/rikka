import os, re
from urllib.parse import quote

def doParser(collection, path, mediaName):
    media = {}
    pages = []
    mediaType = 'Artwork'
    pageList = os.listdir(path)
    media['pageCount'] = 0
    timePattern = re.compile('([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))([ ])([0-1]?[0-9]|2[0-3])-([0-5][0-9])')

    createTime = timePattern.search(path).group()
    media['coverUrl'] = ''
    media['description'] = ''
    media['title'] = mediaName.replace(createTime, '')
    for page in pageList:
        pagePath = os.path.join(path, page)
        pageAddress = 'file:///' + quote(pagePath)
        
        # _cover_ -> Cover image
        if media['coverUrl'] == '' and page.find('_cover_') != -1:
            media['coverUrl'] = pageAddress
        
        # .txt -> Description
        elif media['description'] == '' and page.endswith('.txt'):
            with open(pagePath, 'r', encoding='utf-8') as f:
                media['description'] = f.read()
                f.close()
                
        # Image
        else:
            pages.append(pageAddress)
            media['pageCount'] += 1
    
    if media['coverUrl'] == '':
        media['coverUrl'] = pages[0]
    
    media['collectionGlobalId'] = collection['collectionGlobalId']
    
    return {
        'mediaType': mediaType,
        'media': media,
        'pages': pages
        }