<script setup>
import BoardListItem from "./BoardListItem.vue";
const allitems = 12;
const page = 1;
const pageitems = 4;
</script>

<template>
  <div class="container">
    <h1>일정 공유 게시판</h1>
    <div class="itembox">
      <!-- 4개 단위로 보여줄건데 스크롤 할 때 마다 페이지네이션 되게 -->
      <BoardListItem v-for="i in allitems" :key="i"></BoardListItem>
    </div>
  </div>
</template>

<style scoped>
.container {
  width: 80%;

  background-color: #f2f2f2;

  margin: 0 auto;
}
.itembox {
  border: 1px solid black;
}
</style>
