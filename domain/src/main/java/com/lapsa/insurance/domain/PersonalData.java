package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import com.lapsa.commons.elements.Localized;
import com.lapsa.commons.function.MyStrings;
import com.lapsa.insurance.elements.Sex;
import com.lapsa.validation.NotEmptyString;
import com.lapsa.validation.NotNullValue;
import com.lapsa.validation.ValidDateOfBirth;
import com.lapsa.validation.ValidHumanName;

public class PersonalData extends BaseDomain {
    private static final long serialVersionUID = 6108831386319756885L;
    private static final int PRIME = 71;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @NotNullValue
    @NotEmptyString
    @ValidHumanName
    private String name;

    @NotNullValue
    @NotEmptyString
    @ValidHumanName
    private String surename;

    @NotNullValue
    @NotEmptyString
    @ValidHumanName
    private String patronymic;

    @NotNullValue
    @ValidDateOfBirth
    private LocalDate dayOfBirth;

    @NotNullValue
    private Sex sex;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(Optional.ofNullable(getFullName()) //
		.map(MyStrings::nullOnEmpty)
		.orElseGet(() -> PERSONAL_DATA.displayName(variant, locale)));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	Optional.ofNullable(dayOfBirth) //
		.map(DateTimeFormatter.ISO_LOCAL_DATE::format)
		.map(PERSONAL_DATA_DOB.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	Optional.ofNullable(sex) //
		.map(Localized.toDisplayNameMapper(variant, locale)) //
		.map(PERSONAL_DATA_SEX.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }

    public String getFullName() {
	StringJoiner sj = new StringJoiner(" ");

	Optional.ofNullable(surename) //
		.map(MyStrings::nullOnEmpty)
		.map(String::trim)
		.map(MyStrings::capitalizeFirstLetter)
		.ifPresent(sj::add);

	Optional.ofNullable(name) //
		.map(MyStrings::nullOnEmpty)
		.map(String::trim)
		.map(MyStrings::capitalizeFirstLetter)
		.ifPresent(sj::add);

	Optional.ofNullable(name) //
		.map(x -> patronymic) // patronymic used only in conjuction with
				      // first name
		.map(MyStrings::nullOnEmpty)
		.map(String::trim)
		.map(MyStrings::capitalizeFirstLetter)
		.ifPresent(sj::add);

	return MyStrings.nullOnEmpty(sj.toString());
    }

    // GENERATED

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSurename() {
	return surename;
    }

    public void setSurename(String surename) {
	this.surename = surename;
    }

    public String getPatronymic() {
	return patronymic;
    }

    public void setPatronymic(String patronymic) {
	this.patronymic = patronymic;
    }

    public LocalDate getDayOfBirth() {
	return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
	this.dayOfBirth = dayOfBirth;
    }

    public Sex getSex() {
	return sex;
    }

    public void setSex(Sex sex) {
	this.sex = sex;
    }
}
