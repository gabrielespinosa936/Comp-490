package com.example.brianthoms.criminalintent;


import android.support.v4.app.Fragment;

/**
 * Created by brianthoms on 2/24/18.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
