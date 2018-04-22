package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/19
 */

public class RedisUtils {
    private Jedis jedis;
    private JedisPool jedisPool;

    private static String KEY_PRE = "REDIS_LOCK_";
    private DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static String SET_SUCCESS = "OK";
    private Integer lockExpirseTime;
    private Integer tryExpirseTime;


    public RedisUtils() {
        initialPool();
        jedis = jedisPool.getResource();
    }



    private void initialPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        //�����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��
        config.setMaxTotal(1024);
        //����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����Ĭ��ֵҲ��8��
        config.setMaxIdle(1000);
        //�ȴ��������ӵ����ʱ�䣬��λ���룬Ĭ��ֵΪ-1����ʾ������ʱ����������ȴ�ʱ�䣬��ֱ���׳�
        config.setMaxWaitMillis(10000);
        //��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);

        jedisPool = new JedisPool(config, "127.0.0.1", 6379);

    }


    public String get(String key) {
        String getStr = jedis.get(key);
        return getStr;
    }

    public String set(String key, String value) {
        String setStr = jedis.set(key, value);
        return setStr;
    }


    public String lock(String key) {
        key = KEY_PRE + key;
        String value = fetchLockValue();
        try {
            if (SET_SUCCESS.equals(jedis.set(key, value, "NX", "EX", lockExpirseTime))) {
                System.out.println("Reids Lock key : " + key + ",value : " + value);
                return value;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return value;
    }

    public String tryLock(String key) {
        try {
            key = KEY_PRE + key;
            String value = fetchLockValue();
            Long firstTryTime = System.currentTimeMillis();
            do {
                if (SET_SUCCESS.equals(jedis.set(key, value, "NX", "EX", lockExpirseTime))) {
                    System.out.println("Reids Lock key : " + key + ",value : " + value);
                    return value;
                }
                System.out.println("Redis lock failure,waiting try next");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while ((System.currentTimeMillis() - tryExpirseTime * 1000) < firstTryTime);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    public boolean unLock(String key, String value) {
        Long RELEASE_SUCCESS = 1L;
        try {
            key = KEY_PRE + key;
            String command = "if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
            if (RELEASE_SUCCESS.equals(jedis.eval(command, Collections.singletonList(key), Collections.singletonList(value)))) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    /**
     * ���ɼ�����Ψһ�ַ���
     *
     * @return Ψһ�ַ���
     */
    private String fetchLockValue() {
        return UUID.randomUUID().toString() + "_" + df.format(new Date());
    }

    public void setLockExpirseTime(Integer lockExpirseTime) {
        this.lockExpirseTime = lockExpirseTime;
    }

    public void setTryExpirseTime(Integer tryExpirseTime) {
        this.tryExpirseTime = tryExpirseTime;
    }

    public static void main(String[] args) {
        RedisUtils rs=new RedisUtils();
        rs.set( "test","222222" );
        System.out.println(rs.get( "test"));
    }
}
