# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2017-10-24 18:42
from __future__ import unicode_literals

from django.db import migrations, models
import django.utils.timezone


class Migration(migrations.Migration):

    dependencies = [
        ('first_app', '0002_auto_20171024_1737'),
    ]

    operations = [
        migrations.AddField(
            model_name='items',
            name='created_at',
            field=models.DateTimeField(auto_now_add=True, default=django.utils.timezone.now),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='items',
            name='name',
            field=models.CharField(default=django.utils.timezone.now, max_length=255),
            preserve_default=False,
        ),
        migrations.AlterField(
            model_name='items',
            name='wishes',
            field=models.ManyToManyField(related_name='products', to='first_app.users'),
        ),
    ]