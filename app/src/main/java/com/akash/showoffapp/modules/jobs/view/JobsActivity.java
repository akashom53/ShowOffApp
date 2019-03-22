package com.akash.showoffapp.modules.jobs.view;

import com.akash.showoffapp.R;
import com.akash.showoffapp.base.BaseActivity;
import com.akash.showoffapp.modules.jobs.JobsPresenter;

public class JobsActivity extends BaseActivity<JobsPresenter> implements IJobsView {
    @Override
    protected Class<JobsPresenter> getPresenterClass() {
        return JobsPresenter.class;
    }

    @Override
    protected void onViewReady() {
        setTitle("Job Schedules");
    }

    @Override
    protected void findViews() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_jobs;
    }
}
