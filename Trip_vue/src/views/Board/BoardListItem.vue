<script setup></script>

<template>
  <div class="item">
    <div class="detail">썸네일</div>
    <div class="detail">게시글제목</div>
    <div class="detail">시작날짜~종료날짜</div>
    <div class="detail">작성자</div>
    <div class="detail">조회수, 좋아요</div>
  </div>
</template>

<style scoped>
.item {
  display: flex;
  margin: 1rem 1rem;
  border: 1px solid gray;
  border-radius: 10px;
  text-align: center;
}
.detail {
  width: 25%;
  height: 200px;
  border: 1px solid gray;
}
</style>
