from django.conf.urls import url
from django.contrib import admin
from . import views
from ..first_app.models import users, reviews, books  # This line is new!
urlpatterns = [
  url(r'^$', views.index, name = 'index'),
  url(r'^addreview', views.addreview, name = 'addreview'),
  url(r'bookreview', views.bookreview, name="bookreview"),
  url(r'^register$',views.register, name='register'),
  url(r'^submitreview', views.submitreview, name = 'submitreview'),
]