Generate Key Store
====
keytool -genkeypair -alias igitrasKey -keyalg RSA -keypass igitrasPass -keystore igitras.jks -storepass igitrasStorePass
What is your first and last name?
  [Unknown]:  Mason Mei
What is the name of your organizational unit?
  [Unknown]:  igitras.com
What is the name of your organization?
  [Unknown]:  igitras
What is the name of your City or Locality?
  [Unknown]:  bj
What is the name of your State or Province?
  [Unknown]:  bj
What is the two-letter country code for this unit?
  [Unknown]:  CN
Is CN=Mason Mei, OU=igitras.com, O=igitras, L=bj, ST=bj, C=CN correct?
  [no]:  yes

Create Certification
====
keytool -export -keystore igitras.jks -alias igitrasKey -file igitras.cer
Enter keystore password:  
Certificate stored in file <igitras.cer>

Read public key
====
openssl x509 -inform der -in igitras.cer -pubkey -noout
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlWiFyo0kTkg9cikrO9R8
ZkBiTRBh4SuA5KbzX/fcfj+MJ0e5uka3L58lYP/U3YZI76uMzB6eOlDnamUmWQLF
TuYbKvgZckYV8bID3Nde8Q1iw3JLiUTSMG2YucR+W+y0kaxPlLO1+LJhY1PI62cU
jsRMpg/9njcXz4Nr9uPkpfpb6KfxkRtVsec5MnwvzwhLk9zToURGfkgqIPzMXbXl
0em3dRZx43vViPh8nsSvG+nb36tG5qFkYBhox7wIeissMiJonPtJMPTafHo52mA5
iz6tQCLp1TQXvmWDyMuSa77j0HDhM72EtLgDpfI6GJPFnYFspLH7K/yKhuJj97uT
yQIDAQAB
-----END PUBLIC KEY-----
