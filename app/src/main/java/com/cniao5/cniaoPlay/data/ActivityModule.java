package com.cniao5.cniaoPlay.data;

import com.cniao5.cniaoPlay.pojo.UserInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mcdull.
 */
@Module
public class ActivityModule {

    @Provides
    UserInfo provideUserInfo() {
        return new UserInfo();
    }
}
