package io.qase;

import io.qase.page_object.*;
import io.qase.value_object.StepData;
import io.qase.value_object.TestCaseData;
import org.testng.annotations.Test;

import static java.util.Arrays.asList;

public class TestRunCreate extends BaseTest {

    @Test
    public void testRunCreate() {

        LoginPage loginPage = new LoginPage();
        loginPage.login("gapontsev91@gmail.com", "pass1234");

        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.createNewProject();

        NewProjectPage newProjectPage = new NewProjectPage();
        newProjectPage.newProject("TestQase Testing");

        TestCaseData testCaseData = new TestCaseData(
                asList(
                        new StepData("Step1", "", "step1 completed"),
                        new StepData("Step2", "step 2 data", "step2 completed")
                )
        );

        TestRepositoryPage testRepositoryPage = new TestRepositoryPage();
        testRepositoryPage.createNewCase("QaseOne");
        testRepositoryPage.createCaseSteps(testCaseData);
        testRepositoryPage.createTestRun();

        TestRunsPage testRunsPage = new TestRunsPage();
        testRunsPage.startNewTestRun("QaseIO Test run");

    }
}
