package com.example.portfolio.common.response;

import com.example.portfolio.common.entity.Skill;

import java.util.Set;

public record ProjectResponse(String slug, String title, String  description, Set<Skill> skills, String githubUrl, String demoUrl, int displayOrder) {
}
