<script setup>
import { defineProps, ref } from "vue";
const props = defineProps({ item: Object });
const imgsrc = ref("");
imgsrc.value = props.item.content.firstImage;
</script>

<template>
  <div class="item">
    <!-- <div class="imgbox">
      <img v-if="item.content.firstImage" :src="item.content.firstImage" alt="사진" />
      <img v-else src="@/assets/logo0.svg" alt="사진" />
    </div> -->

    <div class="item-info">
      {{ item.content.title }}
      <p>{{ item.memo }}</p>
      <p>{{ item.cost }}</p>
    </div>
  </div>
</template>

<style scoped>
.item {
  display: flex;
  flex-direction: row;
  margin: 5px;

  height: 90px;
  background-color: white;
  border-radius: 10px;
}
#imgbox {
  margin-left: 10px;
  margin-top: 20px;
}
img {
  width: 50px;
  height: 50px;
}
.item-info {
  margin: 10px 10px 0px 10px;
  font-weight: bold;
  color: var(--main-color);
}
</style>
