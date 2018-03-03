package com.hao;

import com.hao.config.BeanConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * com.hao
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 13:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = BeanConfig.class)
public class BaseTestSupport {
}
