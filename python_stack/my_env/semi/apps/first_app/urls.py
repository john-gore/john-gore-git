from django.conf.urls import url
from . import views           # This line is new!
urlpatterns = [
    url(r'^$', views.index),
    url(r'^addnew', views.addnew),
    url(r'^new', views.new),
    url(r'^show', views.show),
    url(r'^edit', views.edit),
    url(r'^user.edit', views.delete),
    url(r'^delete', views.delete),
    url(r'^goback', views.index),
]