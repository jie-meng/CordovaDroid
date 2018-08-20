# -*- coding: utf-8 -*-

from tools.build import build
from tools.upload import upload

if __name__ == "__main__":
    command = int(input('Please select command: 1.build, 2.upload\n'))
    if command == 1:
        build()
    elif command == 2:
        upload()
    else:
        print('Unknown command: ' + command)
