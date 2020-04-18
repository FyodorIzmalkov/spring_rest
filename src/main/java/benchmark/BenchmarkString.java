package benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * # JMH version: 1.19
 * # VM version: JDK 1.8.0_211, VM 25.211-b12
 * # VM invoker: C:\Program Files\Java\jdk1.8.0_211\jre\bin\java.exe
 * # VM options: -Xms2G -Xmx2G
 * # Warmup: 5 iterations, 1 s each
 * # Measurement: 20 iterations, 1 s each
 * # Timeout: 10 min per iteration
 * # Threads: 1 thread, will synchronize iterations
 * # Benchmark mode: Average time, time/op
 * # Parameters: (N = 10000000)
 *
 * Benchmark           (N)  Mode  Cnt     Score    Error  Units
 * concat         10000000  avgt   20   281.139 ±  2.692  ms/op
 * plus           10000000  avgt   20   148.072 ±  1.190  ms/op
 * stringBuffer   10000000  avgt   20   151.621 ±  1.074  ms/op
 * stringBuilder  10000000  avgt   20   151.446 ±  0.878  ms/op
 * stringFormat   10000000  avgt   20  6270.799 ± 43.545  ms/op
 */

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 10)
@Measurement(iterations = 30)
public class BenchmarkString {

    @Param({"1000000"})
    private int N;
    private final String s1 = new String("1234567890124567890");
    private final String s2 = new String("1234567890124567890");

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkString.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void plus(Blackhole bh) {
        for (int i = 0; i < N; i++) {
            String s = s1 + s2;
        }
    }

    @Benchmark
    public void stringBuilder(Blackhole bh) {
        for (int i = 0; i < N; i++) {
            String s = new StringBuilder(s1).append(s2).toString();
        }
    }

    @Benchmark
    public void stringBuffer(Blackhole bh) {
        for (int i = 0; i < N; i++) {
            String s = new StringBuffer(s1).append(s2).toString();
        }
    }

    @Benchmark
    public void concat(Blackhole bh) {
        for (int i = 0; i < N; i++) {
            String s = s1.concat(s2);
        }
    }
}
