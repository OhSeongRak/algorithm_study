def solution(phone_book):
    phone_book.sort()

    for i, pn in enumerate(phone_book[:-1]):
        if phone_book[i+1].startswith(pn):
            return False
    return True
