package com.stdio.student_management.view;

import com.stdio.student_management.service.IStudentService;
import com.stdio.student_management.service.StudentServiceImpl;

public class Main {
    private final IStudentService studentService = new StudentServiceImpl();
}
