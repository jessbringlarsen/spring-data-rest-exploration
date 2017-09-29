package dk.bringlarsen.bportal.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;

@EnableConfigurationProperties

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ApplicationProperties.class })
@TestPropertySource("/dk/bringlarsen/bportal/configuration/application.properties")
public class ApplicationPropertiesTest {

    @Autowired
    private ApplicationProperties properties;

    @Test
    public void testGetUserName() throws Exception {
        Assert.assertThat(properties.getUsername(), is("jebla"));
    }

    @Test
    public void testGetPort() throws Exception {
        Assert.assertThat(properties.getPort(), is(8080));
    }

    @Test
    public void testGetDb() {
        Assert.assertThat(properties.getDb().getUsername(), is("jebla"));
        Assert.assertThat(properties.getDb().getPassword(), is("1234"));
    }
}