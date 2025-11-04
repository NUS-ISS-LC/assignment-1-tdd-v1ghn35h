package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ToDoListTest  {
    // Define Test Fixtures

    private Task task1;
    private Task task2;
    private ToDoList toDoList;

    public ToDoListTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
        toDoList = new ToDoList();
        task1 = new Task("Task 1");
        task2 = new Task("Task 2");
    }

    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
    }

    @Test
    public void testAddTask() {
        toDoList.addTask(task1);

        assertTrue(toDoList.getAllTasks().contains(task1));
    }

    @Test
    public void testGetStatus() {
        toDoList.addTask(task1);
        assertFalse(toDoList.getStatus("Task 1"));

        toDoList.completeTask("Task 1");
        assertTrue(toDoList.getStatus("Task 1"));
    }

    @Test
    public void testRemoveTask() {
        toDoList.addTask(task1);
        toDoList.addTask(task2);

        Task removed = toDoList.removeTask("Task 1");
        assertEquals(task1, removed);
        assertFalse(toDoList.getAllTasks().contains(task1));
        assertTrue(toDoList.getAllTasks().contains(task2)); 
    }

    @Test
    public void testGetCompletedTasks() {
        toDoList.addTask(task1);
        toDoList.addTask(task2);

        toDoList.completeTask("Task 2");

        Collection<Task> completedTasks = toDoList.getCompletedTasks();
        assertTrue(completedTasks.contains(task2));
        assertFalse(completedTasks.contains(task1));
        assertEquals(1, completedTasks.size());
    }
}