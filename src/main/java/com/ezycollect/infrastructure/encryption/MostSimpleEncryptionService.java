package com.ezycollect.infrastructure.encryption;

import java.util.Base64;

public class MostSimpleEncryptionService implements EncryptionService {

  @Override
  public String encrypt(String data) {
    return Base64.getEncoder().encodeToString(data.getBytes());
  }

}
