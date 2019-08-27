package com.luizhtaira.samples.acceptance;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AcceptanceMapperTests extends JUnitStories {

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
				.useStoryLoader(new LoadFromClasspath(this.getClass()))
				.useStoryReporterBuilder(new StoryReporterBuilder()
						.withCodeLocation(codeLocationFromClass(this.getClass()))
						.withFormats(CONSOLE));
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new AccountServicesStep());
	}

	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("open_account.story");
		//return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), "**/*.story", "**/excluded*.story");
	}
}
