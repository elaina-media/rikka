import requests

def createUser(userType, name, avatar, profile):
    data = {
        'name': name,
        'avatar': avatar,
        'profile': profile
    }

    requests.post(rikkaAddress + '/' + userType + '/create', data=data)