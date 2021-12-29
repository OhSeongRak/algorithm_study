def solution(jobs):
    now, answer = 0, 0

    sorted_jobs = sorted(jobs, key=lambda x: x[1])

    while sorted_jobs:
        for i, (request, task_time) in enumerate(sorted_jobs):
            # 처리할 수 있는 작업에는
            if request <= now:
                # 작업을 처리한 다음, 작업 처리까지 소요된 시간을 더해주고서
                # 대기중인 작업 리스트에서 삭제
                now += task_time
                answer += now - request
                del sorted_jobs[i]
                break

            # 마지막 작업까지 확인했는데, 현재 수행할 수 있는 작업이 없으면
            if i == len(sorted_jobs) - 1:
                now += 1

    return answer // len(jobs)
