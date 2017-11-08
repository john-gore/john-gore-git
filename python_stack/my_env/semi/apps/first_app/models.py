from __future__ import unicode_literals
from django.db import models
class BlogManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['first_name']) < 5:
            errors["name"] = "First name should be more than 5 characters"
        if len(postData['email']) < 8:
            errors["desc"] = "Email should be more than 8 characters"
        return errors;
class Blog(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects = BlogManager()
# Create your models here.
