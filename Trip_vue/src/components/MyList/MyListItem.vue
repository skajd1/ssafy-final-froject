<script setup>
defineProps({
  item: Object,
});
</script>

<template>
  <div>
    <div>{{ item.pid }}</div>
    <div>{{ item.title }}</div>
    <div>{{ item.uid }}</div>
  </div>
</template>

<style scoped></style>
