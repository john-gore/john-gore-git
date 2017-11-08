from __future__ import unicode_literals
from django.db import models

class users(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
class books(models.Model):
    name = models.CharField(max_length=255)
    comment = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    # Notice the association made with ForeignKey for a one-to-many relationship
    # There can be many comments to one blog
    user = models.ForeignKey(users, related_name = "book")
    booklikes = models.ManyToManyField(users, related_name="userlikes")
# Create your models here.
