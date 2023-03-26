import user, collection

rikkaAddress = input('Rikka address(Default: http://127.0.0.1:8080): ') or 'http://127.0.0.1:8080'

def menu(options, start, end):
    print('=======Menu=======')
    for option in options:
        print(option)
    while True:
        try:
            choice = int(input())
            if choice >= start and choice <= end:
                break
        except:
            pass
        print('Wrong input!')
    return choice

module = menu(
    ['(1) User', '(2) Collection'],
    1, 2
)

match module:
    case 1:
        function = menu(
            ['(1) CreateUser'],
            1, 1
        )
        
        match function:
            case 1:
                userType = input('userType: ')
                name = input('name: ')
                avatar = input('avatar: ')
                profile = input('profile: ')
                user.createUser(userType, name, avatar, profile)