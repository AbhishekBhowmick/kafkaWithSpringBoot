package com.musti.ingest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Darshan Nagesh
 *
 */

public class FeedbackES {

		@JsonProperty("appName")
		private String appName;
		@JsonProperty("rate")
		private Integer rate;
		@JsonProperty("feedback")
		private String feedback;
		@JsonProperty("osVersion")
		private String osVersion;
		@JsonProperty("appVersion")
		private String appVersion;
		@JsonProperty("osType")
		private String osType;
		@JsonProperty("deviceType")
		private String deviceType;
		@JsonProperty("userName")
		private String userName;
		@JsonProperty("deviceName")
		private String deviceName;
		@JsonProperty("deviceManufacture")
		private String deviceManufacture;
		@JsonProperty("deviceLocale")
		private String deviceLocale;
		@JsonProperty("deviceScreenResolution")
		private String deviceScreenResolution;
		@JsonProperty("userEvent")
		private String userEvent;

		@JsonProperty("appName")
		public String getAppName() {
		return appName;
		}

		@JsonProperty("appName")
		public void setAppName(String appName) {
		this.appName = appName;
		}

		@JsonProperty("rate")
		public Integer getRate() {
		return rate;
		}

		@JsonProperty("rate")
		public void setRate(Integer rate) {
		this.rate = rate;
		}

		@JsonProperty("feedback")
		public String getFeedback() {
		return feedback;
		}

		@JsonProperty("feedback")
		public void setFeedback(String feedback) {
		this.feedback = feedback;
		}

		@JsonProperty("osVersion")
		public String getOsVersion() {
		return osVersion;
		}

		@JsonProperty("osVersion")
		public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
		}

		@JsonProperty("appVersion")
		public String getAppVersion() {
		return appVersion;
		}

		@JsonProperty("appVersion")
		public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
		}

		@JsonProperty("osType")
		public String getOsType() {
		return osType;
		}

		@JsonProperty("osType")
		public void setOsType(String osType) {
		this.osType = osType;
		}

		@JsonProperty("deviceType")
		public String getDeviceType() {
		return deviceType;
		}

		@JsonProperty("deviceType")
		public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
		}

		@JsonProperty("userName")
		public String getUserName() {
		return userName;
		}

		@JsonProperty("userName")
		public void setUserName(String userName) {
		this.userName = userName;
		}

		@JsonProperty("deviceName")
		public String getDeviceName() {
		return deviceName;
		}

		@JsonProperty("deviceName")
		public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
		}

		@JsonProperty("deviceManufacture")
		public String getDeviceManufacture() {
		return deviceManufacture;
		}

		@JsonProperty("deviceManufacture")
		public void setDeviceManufacture(String deviceManufacture) {
		this.deviceManufacture = deviceManufacture;
		}

		@JsonProperty("deviceLocale")
		public String getDeviceLocale() {
		return deviceLocale;
		}

		@JsonProperty("deviceLocale")
		public void setDeviceLocale(String deviceLocale) {
		this.deviceLocale = deviceLocale;
		}

		@JsonProperty("deviceScreenResolution")
		public String getDeviceScreenResolution() {
		return deviceScreenResolution;
		}

		@JsonProperty("deviceScreenResolution")
		public void setDeviceScreenResolution(String deviceScreenResolution) {
		this.deviceScreenResolution = deviceScreenResolution;
		}

		@JsonProperty("userEvent")
		public String getUserEvent() {
		return userEvent;
		}

		@JsonProperty("userEvent")
		public void setUserEvent(String userEvent) {
		this.userEvent = userEvent;
		}
}
