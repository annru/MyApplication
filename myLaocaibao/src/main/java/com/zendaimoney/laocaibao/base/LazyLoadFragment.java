package com.zendaimoney.laocaibao.base;

/**
 * Created by 00224524 on 2017/7/21.
 * description:懒加载基类
 */

public abstract class LazyLoadFragment extends BaseFragment {
    protected boolean isVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInVisible();
        }
    }

    protected abstract void lazyLoad();

    protected void onVisible() {
        lazyLoad();
    }

    protected void onInVisible() {

    }
}
