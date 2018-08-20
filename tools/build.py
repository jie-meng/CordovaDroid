# -*- coding: utf-8 -*-

import os

def build():
    appName = 'CordovaDroid'
    packageName = 'com.jmengxy.cordovadroid'
    webProjectName = 'web'

    flavorType = int(input('Please select flavor: 1.qa, 2.prod\n'))
    flavor = 'Prod' if flavorType == 2 else 'Qa'

    buildType = int(input('Please select build Type: 1.debug, 2.release\n'))
    build = 'Release' if buildType == 2 else 'Debug'

    print('build ...')
    projectPath = os.getcwd()
    os.chdir(projectPath + '/{0}'.format(webProjectName))
    os.system('npm i && npm run build')
    os.chdir(projectPath)
    # os.system('cp -r {0}/www/. app/src/main/assets/www'.format(webProjectName))
    # os.system('cp -r {0}/src/images/. app/src/main/assets/www/images'.format(webProjectName))
    applicationIdExt = '' if flavorType == 2 else '.qa'

    os.system('./gradlew assemble{0}{1}'.format(flavor, build))

    os.system('adb push app/src/main/assets/www/. /sdcard/Android/data/{0}{1}/www'.format(packageName, applicationIdExt))
    os.system('adb push {0}/www/. /sdcard/Android/data/{1}{2}/www'.format(webProjectName, packageName, applicationIdExt))
    os.system('adb push {0}/src/images/. /sdcard/Android/data/{1}{2}/www/images'.format(webProjectName, packageName, applicationIdExt))