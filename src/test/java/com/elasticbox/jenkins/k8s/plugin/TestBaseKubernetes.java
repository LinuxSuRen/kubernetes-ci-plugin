/*
 * Copyright 2016 ElasticBox
 *
 * Licensed under the Apache License, Version 2.0, <LICENSE-APACHE or http://apache.org/licenses/LICENSE-2.0>
 * or the MIT license <LICENSE-MIT or http://opensource.org/licenses/MIT> , at your option.
 * This file may not be copied, modified, or distributed except according to those terms.
 */

package com.elasticbox.jenkins.k8s.plugin;

import com.elasticbox.jenkins.k8s.plugin.clouds.ChartRepositoryConfig;
import com.elasticbox.jenkins.k8s.plugin.clouds.KubernetesCloud;
import com.elasticbox.jenkins.k8s.plugin.clouds.PodSlaveConfig;
import org.junit.Before;
import org.junit.Rule;
import org.jvnet.hudson.test.JenkinsRule;

import java.util.Collections;

public class TestBaseKubernetes {

    protected static final String EMPTY = "";
    protected static final String FAKE_URL = "http://fake.url";
    protected static final String FAKE_NS = "fakeNs";
    protected static final String FAKE_CHARTS_REPO = "FakeChartsRepo";
    protected static final String FAKE_MOCK_EXCEPTION = "FakeMockException";

    @Rule
    public JenkinsRule jenkins = new JenkinsRule();

    protected ChartRepositoryConfig fakeChartRepoCfg;
    protected KubernetesCloud cloud;

    @Before
    public void setupCloud() throws Exception {
        fakeChartRepoCfg = new ChartRepositoryConfig(FAKE_CHARTS_REPO, FAKE_URL, EMPTY);
        PodSlaveConfig fakePodSlaveConfig = new PodSlaveConfig("fakeID", "fakePodSlaveConfig", EMPTY, EMPTY);

        cloud = new KubernetesCloud(EMPTY, "FakeKubeCloud", FAKE_URL, FAKE_NS, "10", EMPTY, EMPTY,
                                    Collections.singletonList(fakeChartRepoCfg), Collections.singletonList(fakePodSlaveConfig));

        jenkins.getInstance().clouds.add(cloud);
    }

}
