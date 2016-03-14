package com.smallfish.qiongyou.util;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

/**
 * Created by Joshua_Chang on 16/3/10.
 */
public class FragmentUtils implements RadioGroup.OnCheckedChangeListener {
    private FragmentManager manager;
    private int containerId;
    private List<Fragment> fragments;
    private OnfragmentItemClick onfragmentItemClick;


    public void setOnfragmentItemClick(OnfragmentItemClick onfragmentItemClick) {
        this.onfragmentItemClick = onfragmentItemClick;
    }

    public FragmentUtils(FragmentManager manager,RadioGroup radioGroup, int containerId, List<Fragment> fragments, OnfragmentItemClick onfragmentItemClick) {
        this.manager = manager;
        this.containerId = containerId;
        this.fragments = fragments;
        this.onfragmentItemClick = onfragmentItemClick;
        radioGroup.setOnCheckedChangeListener(this);
        ((RadioButton)radioGroup.getChildAt(0)).setChecked(true);
    }

    public FragmentUtils(FragmentManager manager,RadioGroup radioGroup, int containerId, List<Fragment> fragments) {
        this(manager,radioGroup,containerId,fragments,null);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < fragments.size(); i++) {
            if (checkedId ==group.getChildAt(i).getId())
            {
                if (!fragments.get(i).isAdded()) {
                    getTransaction().add(containerId,fragments.get(i)).commit();
                }
                if (onfragmentItemClick != null) {
                    onfragmentItemClick.onItemClick(i,group,checkedId);
                }
                getTransaction().show(fragments.get(i)).commit();
            }
            else {getTransaction().hide(fragments.get(i)).commit();}
        }
    }
    private FragmentTransaction getTransaction()
    {
        return manager.beginTransaction();
    }
    public interface OnfragmentItemClick
    {
        void onItemClick(int index, RadioGroup group, int checkedId);
    }
}
