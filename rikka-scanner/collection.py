import requests, json, sys, os

scanPath = input('Scan path: ')
rikkaAddress = input('Rikka address(Default: http://127.0.0.1:8080): ') or 'http://127.0.0.1:8080'

# Load config
config = input('Config path(Default: scanPath/rikka.config.json): ') or os.path.join(scanPath, 'rikka.config.json')
with open(config, 'r') as f:
    config = json.load(f)
    f.close()

# Import parser
sys.path.append(scanPath)
import mediaParser

# Get media list
mediaList = os.listdir(scanPath)
for meidaName in mediaList:
    if os.path.isfile(os.path.join(scanPath, meidaName)):
        mediaList.remove(meidaName)

mediaList.remove('rikka.config.json')
mediaList.remove('__pycache__')

# Create collection
# req = requests.post(rikkaAddress + '/collection/createSingle', data=config['collection'])
# collection = json.loads(req.text)
collection = json.loads('{"bookmarkCount": 0, "collectionGlobalId": 4, "coverUrl": "https://pixiv.pximg.net/c/160x160_90_a2_g5/fanbox/public/images/user/3231927/icon/9XQXy8kGaaeCUV9BV0LcYDOu.jpeg", "createTime": "2023-03-26T04:39:15.000+00:00", "description": null, "firstMediaGlobalId": 0, "firstMediaType": "Artwork", "grading": 0, "likeCount": 0, "tags": null, "title": "AkiFn", "updateTime": "2023-03-26T04:39:15.000+00:00", "uploaderGlobalId": 1, "viewCount": 0}')

mediaResultList = []

for mediaName in mediaList:
    path = os.path.join(scanPath, mediaName)
    result = mediaParser.doParser(collection, path, mediaName)
    mediaResultList.append(result)

mediaResult = {
    'collectionGlobalId': collection['collectionGlobalId'],
    'media': mediaResultList
}
requests.post(rikkaAddress + '/collection/initCollection', json=mediaResult)