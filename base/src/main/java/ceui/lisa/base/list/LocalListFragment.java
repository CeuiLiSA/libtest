package ceui.lisa.base.list;

import androidx.databinding.ViewDataBinding;


import ceui.lisa.base.repo.Repo;

public abstract class LocalListFragment<Layout extends ViewDataBinding, Item>
        extends ListFragment<Layout, Item> {

    @Override
    public void first() {
    }

    @Override
    public void next() {

    }
}
