from django.conf.urls import url
from django.contrib import admin
from . import views
from ..first_app.models import users, items    # This line is new!
urlpatterns = [
    url(r'^$', views.index, name = 'index'),
    url(r'^additem$', views.additem, name = 'additem'),
]