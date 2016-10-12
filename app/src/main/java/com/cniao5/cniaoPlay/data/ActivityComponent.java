package com.cniao5.cniaoPlay.data;

import com.cniao5.cniaoPlay.ui.activity.MainActivity;
import com.cniao5.cniaoPlay.ui.fragment.GameFragment;

import dagger.Component;

/**
 * Created by mcdull.
 */
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(GameFragment gameFragment);
}