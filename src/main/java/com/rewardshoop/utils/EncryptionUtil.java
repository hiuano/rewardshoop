package com.rewardshoop.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.util.UUID;

public class EncryptionUtil {

    public static final String encodeRules = getUUID();

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */

    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * 加密 1.构造密钥生成器 2.根据ecnodeRules规则初始化密钥生成器 3.产生密钥 4.创建和初始化密码器 5.内容加密 6.返回字符串
     *
     * @param encodeRules
     * @param content
     * @return
     */
    public static String AESEncode(String encodeRules, String content) {
        try {
            // 1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            // 2.根据ecnodeRules规则初始化密钥生成器
            // 生成一个128位的随机源,根据传入的字节数组
            keygen.init(128, new SecureRandom(encodeRules.getBytes()));
            // 3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            // 4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            // 5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            // 6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            // 8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byte_encode = content.getBytes("utf-8");
            // 9.根据密码器的初始化方式--加密：将数据加密
            byte[] byte_AES = cipher.doFinal(byte_encode);
            // 10.将加密后的数据转换为字符串
            // 这里用Base64Encoder中会找不到包
            // 解决办法：
            // 在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
            String AES_encode = new String(new BASE64Encoder().encode(byte_AES));
            // 11.将字符串返回
            return AES_encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 如果有错就返加nulll
        return null;
    }

    /**
     * 解密 解密过程： 1.同加密1-4步 2.将加密后的字符串反纺成byte[]数组 3.将加密内容解密
     *
     * @param encodeRules
     * @param content
     * @return
     */
    public static String AESDncode(String encodeRules, String content) {
        try {
            // 1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            // 2.根据ecnodeRules规则初始化密钥生成器
            // 生成一个128位的随机源,根据传入的字节数组
            keygen.init(128, new SecureRandom(encodeRules.getBytes()));
            // 3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            // 4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            // 5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            // 6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            // 8.将加密并编码后的内容解码成字节数组
            byte[] byte_content = new BASE64Decoder().decodeBuffer(content);
            /*
             * 解密
             */
            byte[] byte_decode = cipher.doFinal(byte_content);
            String AES_decode = new String(byte_decode, "utf-8");
            return AES_decode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        // 如果有错就返加nulll
        return null;
    }

    /**
     * 生成32位md5码
     * <p>
     * 加盐方式,小写
     *
     * @param password
     * @return
     */
    public static String md5Password(String password) {

        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }

    /**
     * MD5解密
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String md5 = new BigInteger(1, md.digest()).toString(16);
            // BigInteger会把0省略掉，需补全至32位
            return fillMD5(md5);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误:" + e.getMessage(), e);
        }
    }

    public static String fillMD5(String md5) {
        return md5.length() == 32 ? md5 : fillMD5("0" + md5);
    }

    /**
     * 神奇的MD5加密,调通联接口的加密Sign只能用这个
     *
     * @param data
     * @return
     */
    public static String encryptMD5(String data) {
        byte[] bytes = null;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");

            bytes = md.digest(data.getBytes("UTF-8"));
            StringBuilder sign = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(bytes[i] & 0xFF);
                if (hex.length() == 1) {
                    sign.append("0");
                }
                sign.append(hex.toUpperCase());
            }
            return sign.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /**
     * 普通方式,大写
     *
     * @param key
     * @return
     */
    public static String MD5(String key) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 生成UUID
     */
    public static String getUUID() {
        String temp = UUID.randomUUID().toString();
        String str = temp.substring(0, 8) + temp.substring(9, 13) + temp.substring(14, 18) + temp.substring(19, 23)
                + temp.substring(24);
        return str;
    }

    /**
     * DES加密解密的隐藏内部类
     *
     * @author Sven
     */
    private static class DES {

        private static final String strDefaultKey = "abcDEF123";
        private Cipher encryptCipher = null;
        private Cipher decryptCipher = null;

        /**
         * 默认构造方法，使用默认密钥
         *
         * @throws Exception
         */
        public DES() throws Exception {
            this(strDefaultKey);
        }

        /**
         * 指定密钥构造方法
         *
         * @param strKey 指定的密钥
         * @throws Exception
         */
        public DES(String strKey) throws Exception {
            Security.addProvider(new com.sun.crypto.provider.SunJCE());
            Key key = getKey(strKey.getBytes());
            encryptCipher = Cipher.getInstance("DES");
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);
            decryptCipher = Cipher.getInstance("DES");
            decryptCipher.init(Cipher.DECRYPT_MODE, key);
        }

        /**
         * 加密字符串
         *
         * @param strIn 需加密的字符串
         * @return 加密后的字符串
         * @throws Exception
         */
        public String encrypt(String strIn) throws Exception {
            return byteArr2HexStr(encrypt(strIn.getBytes()));
        }

        /**
         * 加密字节数组
         *
         * @param arrB 需加密的字节数组
         * @return 加密后的字节数组
         * @throws Exception
         */
        public byte[] encrypt(byte[] arrB) throws Exception {
            return encryptCipher.doFinal(arrB);
        }

        /**
         * 解密字符串
         *
         * @param strIn 需解密的字符串
         * @return 解密后的字符串
         * @throws Exception
         */
        public String decrypt(String strIn) throws Exception {
            return new String(decrypt(hexStr2ByteArr(strIn)));
        }

        /**
         * 解密字节数组
         *
         * @param arrB 需解密的字节数组
         * @return 解密后的字节数组
         * @throws Exception
         */
        public byte[] decrypt(byte[] arrB) throws Exception {
            return decryptCipher.doFinal(arrB);
        }

        /**
         * 从指定字符串生成密钥，密钥所需的字节数组长度为8位 不足8位时后面补0，超出8位只取前8位
         *
         * @param arrBTmp 构成该字符串的字节数组
         * @return 生成的密钥
         * @throws java.lang.Exception
         */
        private Key getKey(byte[] arrBTmp) throws Exception {
            byte[] arrB = new byte[8];
            for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
                arrB[i] = arrBTmp[i];
            }
            Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
            return key;
        }

        /**
         * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
         * hexStr2ByteArr(String strIn) 互为可逆的转换过程
         *
         * @param arrB 需要转换的byte数组
         * @return 转换后的字符串
         * @throws Exception 本方法不处理任何异常，所有异常全部抛出
         */
        public static String byteArr2HexStr(byte[] arrB) throws Exception {
            int iLen = arrB.length;
            StringBuffer sb = new StringBuffer(iLen * 2);
            for (int i = 0; i < iLen; i++) {
                int intTmp = arrB[i];
                while (intTmp < 0) {
                    intTmp = intTmp + 256;
                }
                if (intTmp < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toString(intTmp, 16));
            }
            return sb.toString();
        }

        /**
         * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)
         * 互为可逆的转换过程
         *
         * @param strIn 需要转换的字符串
         * @return 转换后的byte数组
         * @throws Exception 本方法不处理任何异常，所有异常全部抛出
         */
        public static byte[] hexStr2ByteArr(String strIn) throws Exception {
            byte[] arrB = strIn.getBytes();
            int iLen = arrB.length;
            byte[] arrOut = new byte[iLen / 2];
            for (int i = 0; i < iLen; i = i + 2) {
                String strTmp = new String(arrB, i, 2);
                arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
            }
            return arrOut;
        }

    }

    /**
     * DES加密
     *
     * @param key 秘钥
     * @param content     加密主体
     * @return
     */
    public static String DESEncode(String key, String content) {
        try {
            return new DES(key).encrypt(content);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * DES加密,秘钥为默认值
     *
     * @param content
     * @return
     */
    public static String DESEncode(String content) {
        try {
            return new DES().encrypt(content);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * DES解密
     *
     * @param key 秘钥
     * @param content     解密主体
     * @return
     */
    public static String DESDncode(String key, String content) {
        try {
            return new DES(key).decrypt(content);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * DES解密,秘钥为默认值
     *
     * @param content
     * @return
     */
    public static String DESDncode(String content) {
        try {
            return new DES().decrypt(content);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * DES加密,通联的DES加密方法
     *
     * @param datasource 数据源
     * @param password   数据密钥
     * @return
     */

    public static String DES(String datasource, String password) {

        try {
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(password.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);
            byte[] result = cipher.doFinal(datasource.getBytes());
            BASE64Encoder encode = new BASE64Encoder();
            return encode.encode(result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
