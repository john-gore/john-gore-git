from django.conf.urls import url
from . import views
#app level url view
urlpatterns = [
    url(r'^$', views.index),
    url(r'^checkout$', views.buy)
]