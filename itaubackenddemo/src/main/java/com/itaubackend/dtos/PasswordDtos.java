package com.itaubackend.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.math.BigDecimal;

public record PasswordDtos(BigDecimal value, Long senderId, Long receiverId) {
}
