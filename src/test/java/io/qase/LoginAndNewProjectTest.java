package io.qase;

import io.qase.page_object.*;
import org.testng.annotations.Test;

public class LoginAndNewProjectTest extends BaseTest {

    @Test
    public void loginAndNewProjectTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.login("gapontsev91@gmail.com", "pass1234");

        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.createNewProject();

        NewProjectPage newProjectPage = new NewProjectPage();
        newProjectPage.newProject("Default Testing");

        TestRepositoryPage testRepositoryPage = new TestRepositoryPage();
        testRepositoryPage.createNewCase("Default");
        testRepositoryPage.deleteCase();
        testRepositoryPage.openSettingsPage();

        SettingsPage settingsPage = new SettingsPage();
        settingsPage.deleteProject();

    }
}
