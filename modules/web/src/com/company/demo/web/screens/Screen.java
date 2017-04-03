package com.company.demo.web.screens;

import com.company.demo.entity.Segment;
import com.company.demo.entity.TaskSpan;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class Screen extends AbstractWindow {
    @Inject
    private Chart ganttChart;

    @Inject
    private CollectionDatasource<TaskSpan, UUID> taskSpansDs;

    @Override
    public void init(Map<String, Object> params) {
        generateGanttData();

        ganttChart.addGraphItemClickListener(event -> {
            Segment segment = (Segment) event.getItem();
            TaskSpan taskSpan = segment.getTaskSpan();

            showNotification(String.format("'%s' from '%s'", segment.getTask(), taskSpan.getCategory()),
                    NotificationType.HUMANIZED);
        });
    }

    private void generateGanttData() {
        taskSpansDs.refresh();

        taskSpansDs.includeItem(taskSpan("John",
                segment(7, 2, "#7B742C", "Task #1"),
                segment(null, 2, "#7E585F", "Task #2"),
                segment(null, 2, "#CF794A", "Task #3")
        ));
        taskSpansDs.includeItem(taskSpan("Smith",
                segment(10, 2, "#7E585F", "Task #2"),
                segment(null, 1, "#CF794A", "Task #3"),
                segment(null, 4, "#7B742C", "Task #1")
        ));
        taskSpansDs.includeItem(taskSpan("Ben",
                segment(12, 2, "#7E585F", "Task #2"),
                segment(16, 2, "#FFE4C4", "Task #4")
        ));
        taskSpansDs.includeItem(taskSpan("Mike",
                segment(9, 6, "#7B742C", "Task #1"),
                segment(null, 4, "#7E585F", "Task #2")
        ));
        taskSpansDs.includeItem(taskSpan("Lenny",
                segment(8, 1, "#CF794A", "Task #3"),
                segment(null, 4, "#7B742C", "Task #1")
        ));
        taskSpansDs.includeItem(taskSpan("Scott",
                segment(15, 3, "#7E585F", "Task #2")
        ));
        taskSpansDs.includeItem(taskSpan("Julia",
                segment(9, 2, "#7B742C", "Task #1"),
                segment(null, 1, "#7E585F", "Task #2"),
                segment(null, 8, "#CF794A", "Task #3")
        ));
        taskSpansDs.includeItem(taskSpan("Bob",
                segment(9, 8, "#7E585F", "Task #2"),
                segment(null, 7, "#CF794A", "Task #3")
        ));
        taskSpansDs.includeItem(taskSpan("Kendra",
                segment(11, 8, "#7E585F", "Task #2"),
                segment(16, 2, "#FFE4C4", "Task #4")
        ));
        taskSpansDs.includeItem(taskSpan("Tom",
                segment(9, 4, "#7B742C", "Task #1"),
                segment(null, 3, "#7E585F", "Task #2"),
                segment(null, 5, "#CF794A", "Task #3")
        ));
        taskSpansDs.includeItem(taskSpan("Kyle",
                segment(6, 3, "#7E585F", "Task #2")
        ));
        taskSpansDs.includeItem(taskSpan("Anita",
                segment(12, 2, "#7E585F", "Task #2"),
                segment(16, 2, "#FFE4C4", "Task #4")
        ));
        taskSpansDs.includeItem(taskSpan("Jack",
                segment(8, 10, "#7B742C", "Task #1"),
                segment(null, 2, "#7E585F", "Task #2")
        ));
        taskSpansDs.includeItem(taskSpan("Kim",
                segment(12, 2, "#7E585F", "Task #2"),
                segment(null, 3, "#CF794A", "Task #3")
        ));
        taskSpansDs.includeItem(taskSpan("Aaron",
                segment(18, 2, "#7E585F", "Task #2"),
                segment(null, 2, "#FFE4C4", "Task #4")
        ));
        taskSpansDs.includeItem(taskSpan("Alan",
                segment(17, 2, "#7B742C", "Task #1"),
                segment(null, 2, "#7E585F", "Task #2"),
                segment(null, 2, "#CF794A", "Task #3")
        ));
        taskSpansDs.includeItem(taskSpan("Ruth",
                segment(13, 2, "#7E585F", "Task #2"),
                segment(null, 1, "#CF794A", "Task #3"),
                segment(null, 4, "#7B742C", "Task #1")
        ));
        taskSpansDs.includeItem(taskSpan("Simon",
                segment(10, 3, "#7E585F", "Task #2"),
                segment(17, 4, "#FFE4C4", "Task #4")
        ));
    }

    private TaskSpan taskSpan(String category, Segment... segments) {
        TaskSpan taskSpan = new TaskSpan();
        taskSpan.setCategory(category);
        taskSpan.setSegments(Arrays.stream(segments)
                .peek(segment -> segment.setTaskSpan(taskSpan))
                .collect(Collectors.toList()));
        return taskSpan;
    }

    private Segment segment(Integer start, Integer duration, String color, String task) {
        Segment segment = new Segment();
        segment.setStart(start);
        segment.setDuration(duration);
        segment.setColor(color);
        segment.setTask(task);
        return segment;
    }
}