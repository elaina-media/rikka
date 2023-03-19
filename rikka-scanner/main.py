import requests

scanPath = input('Scan path: ')

rikkaAddress = input('Rikka address(Default: http://127.0.0.1:8080): ') or 'http://127.0.0.1:8080'

config = input('Config path(Default: scanPath/rikka.config.json): ') or scanPath +'/rikka.config.json'

