package com.java.healthcare.service;

import com.java.healthcare.entity.Notification;
import com.java.healthcare.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Create or Update Notification
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // Get Notifications by User ID
    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    // Get Unread Notifications by User ID
    public List<Notification> getUnreadNotifications(Long userId) {
        return notificationRepository.findByUserIdAndIsReadFalse(userId);
    }

    // Mark Notification as Read
    public void markAsRead(Long id) {
        notificationRepository.findById(id).ifPresent(notification -> {
            notification.setRead(true);
            notificationRepository.save(notification);
        });
    }

    // Get All Notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Delete Notification by ID
    public void deleteNotificationById(Long id) {
        notificationRepository.deleteById(id);
    }
}

