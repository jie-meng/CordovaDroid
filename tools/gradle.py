# -*- coding: utf-8 -*-

import os
import re
import platform

class Gradle(object):

    def __init__(self, gradle_file):
        self.__gradle_file = gradle_file
        self.load()

    def load(self):
        with open(self.__gradle_file, 'r') as file:
            self.__content = file.read()

    def update(self, version_code):
        self.__content = re.sub(r'versionCode\s+\d+', 'versionCode ' + str(version_code), self.__content)

    def content(self):
        return self.__content

    def save(self, content = None):
        with open(self.__gradle_file, 'w') as file:
            if content == None:
                file.write(self.__content)
            else:
                file.write(content)

    def upload(self, app_type):
        if platform.system().lower().find('windows') >= 0:
            return 0 == os.system('gradlew.bat clean upload{0}ToHockeyApp'.format(app_type))
        else:
            return 0 == os.system('./gradlew clean upload{0}ToHockeyApp'.format(app_type))