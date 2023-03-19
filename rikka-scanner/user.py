import requests

rikkaAddress = input('Rikka address(Default: http://127.0.0.1:8080): ') or 'http://127.0.0.1:8080'
userType = input('userType: ')
name = input('name: ')
avatar = input('avatar: ')
profile = input('profile: ')

data = {
    'name': name,
    'avatar': avatar,
    'profile': profile
}

requests.post(rikkaAddress + '/' + userType + '/create', data=data)