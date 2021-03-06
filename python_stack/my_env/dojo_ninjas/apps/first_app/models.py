from __future__ import unicode_literals

from django.db import models

class dojos(models.Model):
    name = models.CharField(max_length=255)
    city = models.CharField(max_length=255)
    state = models.CharField(max_length=255)
    
class ninjas(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    # Notice the association made with ForeignKey for a one-to-many relationship
    # There can be many comments to one blog
    user = models.ForeignKey(dojos, related_name = "ninjas")
# Create your models here.
