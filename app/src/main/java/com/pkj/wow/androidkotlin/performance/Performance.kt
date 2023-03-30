package com.pkj.wow.androidkotlin.performance

/*

App performance can be improved by following steps

1. Concurrency :  This will directly impact on time of execution,
we should use thread wisely to concurrently run multiple task on
same time and off load the UI or main thread.
- using coroutines to use thread fully and wisely and easy to control
threads through structured concurrency

2. App startup time: By use of lazy loading we can achieve significant
improvement in app start up time. we should load components when
they first time start to use.

3. Frozen UI / Jank :

4. Design pattern : mostly creation design pattern help in improving app performance

5. Kotlin inline function : For higher order functions we can use inline function
where applicable as it can prevent from creation of unwanted objects.

6. Macrobanchmarking:

7. Memory leak:


macrobanchmarking, bitmap recycle,
cpu profiler to findout jank, frozen frame(skip frame),
memory profiler (start and end activity memory should be same
otherwise memory leak is there),
bettery optimization (periodic tasks, alarm, socket)


- [ ] App performance
- [ ] Memory leaks
- [ ] Release resources and bitmaps on scope clear/view model clear/activity destroy carefully
- [ ] Bitmap leak
- [ ] App startup time
- [ ] ANR threshold
- [ ] Frozen frames
- [ ] Reduce garbage collection (collecting) to improve app performance
- [ ] Profiler (CPU, Memory)

 */