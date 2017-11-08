from django.conf.urls import url
from . import views
urlpatterns = [
    url(r'^$', views.index),
    url(r'^new$', views.index2),
    url(r'^create$', views.create),
    url(r'^15$', views.number),
    url(r'^edit$', views.edit),
    url(r'^delete$', views.delete),
]
