# -*- coding: utf-8 -*-

import sys
from .config import Config
from .hockeyapp import HockeyApp
from .gradle import Gradle

#configs = []
#configs.append(Config(app_type = 'QaRelease', api_token = '', app_id = ''))
#configs.append(Config(app_type = 'ProdRelease', api_token = '', app_id = ''))

#app_type_index = input('Please input upload app type: (1.QaRelease, 2.ProdRelease)\n')
#config = configs[int(app_type_index) - 1]

#print('AppType: {0}\nApiToken: {1}\nAppId: {2}\nselected.\n'.format(config.getAppType(), config.getApiToken(), config.getAppId()))

#print('Get next version ...\n')

#hockeyapp = HockeyApp(config.getApiToken(), config.getAppId())
#nextVersion = hockeyapp.getNextVersion()

#print('\nNext version is {}'.format(nextVersion))

#if nextVersion >= 9999:
#    print('Please delete versions above 9999 on hockeyapp!')
#    sys.exit(-1)

#print('Save gradle content.')
#gradle = Gradle('./app/build.gradle')
#save_content = gradle.content()

#print('Update gradle versionCode to {}.'.format(nextVersion))
#gradle.update(nextVersion)
#gradle.save()

#if gradle.upload(config.getAppType()):
#    print('\ndone!\n')
#else:
#    print('\nerror!!!\n')

## recover build.gradle
#gradle.save(save_content)


def upload():
    print('upload ...')
