package org.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {
	private Set<Task> annsTasks;
	private Set<Task> bobsTasks;
	private Set<Task> carolsTasks;
	private Set<Task> unassignedTasks;

	public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
		this.annsTasks = annsTasks;
		this.bobsTasks = bobsTasks;
		this.carolsTasks = carolsTasks;
		this.unassignedTasks = unassignedTasks;
	}

	public Set<Task> getTasks(String string){

		return switch (string) {
			case "ann" -> annsTasks;
			case "bob" -> bobsTasks;
			case "carol" -> carolsTasks;
			case "all" -> getAllTasks();
			default -> unassignedTasks;
		};
	}
	private Set<Task> getAllTasks(){
		Set<Task> allTasks = new HashSet<>(annsTasks);
		allTasks.addAll(bobsTasks);
		allTasks.addAll(carolsTasks);
		allTasks.addAll(unassignedTasks);
		return allTasks;
	}

	public Set<Task> getUnion(Set<Task> firstSet, Set<Task> secondSet){
		Set<Task> allTasks = new HashSet<>(firstSet);
		allTasks.addAll(secondSet);
		return allTasks;
	}
	public Set<Task> getIntersection(Set<Task> firstSet, Set<Task> secondSet){
		Set<Task> intersectedSet = new HashSet<>(firstSet);
		intersectedSet.retainAll(secondSet);
		return intersectedSet;
	}
	public Set<Task> getDifferences(Set<Task> firstSet, Set<Task> secondSet){
		Set<Task> diffSet = new HashSet<>(firstSet);
		diffSet.removeAll(secondSet);
		return diffSet;
	}

}
