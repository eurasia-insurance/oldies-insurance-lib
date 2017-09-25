package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import com.lapsa.commons.function.MyStrings;
import com.lapsa.insurance.elements.IdentityCardType;
import com.lapsa.insurance.validation.ValidIdentityCardType;
import com.lapsa.validation.NotEmptyString;
import com.lapsa.validation.NotNullValue;
import com.lapsa.validation.ValidDateOfIssue;

public class IdentityCardData extends SidedScannedDocument {
    private static final long serialVersionUID = 6150409229272494445L;
    private static final int PRIME = 37;
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
    @ValidDateOfIssue
    private LocalDate dateOfIssue;

    @NotNullValue
    @NotEmptyString
    private String issuingAuthority;

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    @ValidIdentityCardType
    private IdentityCardType type;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringJoiner sj = new StringJoiner(" ");

	sj.add(Optional.ofNullable(type) //
		.map(x -> x.displayName(variant, locale)) //
		.map(MyStrings::capitalizeFirstLetter) //
		.orElse(IDENTITY_CARD_DATA.displayName(variant, locale)));

	Optional.ofNullable(number)
		.filter(MyStrings::nonEmptyString)
		.map(x -> IDENTITY_CARD_DATA_NUMBER.displayName(variant, locale) + " " + x)
		.ifPresent(sj::add);

	Optional.ofNullable(dateOfIssue) //
		.map(DateTimeFormatter.ISO_LOCAL_DATE::format)
		.map(x -> IDENTITY_CARD_DATA_ISSUED.displayName(variant, locale) + " " + x)
		.ifPresent(sj::add);

	return sj.toString() + appendEntityId();
    }

    // GENERATED

    public LocalDate getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
	this.dateOfIssue = dateOfIssue;
    }

    public String getIssuingAuthority() {
	return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
	this.issuingAuthority = issuingAuthority;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public IdentityCardType getType() {
	return type;
    }

    public void setType(IdentityCardType type) {
	this.type = type;
    }
}
