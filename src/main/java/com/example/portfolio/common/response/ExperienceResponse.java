package com.example.portfolio.common.response;

import java.util.Date;

public record ExperienceResponse(String companyName, String client,String description, String role, Date startDate, Date endDate, String workModel, int displayOrder) {
}
